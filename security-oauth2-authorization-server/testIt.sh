#!/bin/bash
# It makes the use of the tool https://stedolan.github.io/jq/
clear
echo ""

NC='\033[0m'
LBLUE='\033[1;34m'
LGREEN='\033[1;32m'
YELLOW='\033[1;33m'
HEADER='\033[0;33m'
WHITE='\033[1;37m'
LGRAY='\033[0;37m'
LRED='\033[1;31m'
BOLD='\e[1m'
BLINK='\e[5m'

authorizationServer=http://localhost:8081/oauth-server
resourceServer=http://localhost:8082/resource

show=false
if [ "$1" = "show" ]; then
   show=true;
fi

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> (1)  ${WHITE}Retrieve the Access Token from Authorization Server: ${LGRAY}$authorizationServer/oauth/token${HEADER}"
echo -e "######################################################################################################################################${NC}"
jsonTokenAccess="$(curl -s -d 'grant_type=password&username=john&password=123&client_secret=secret&scope=read&client_id=clientIdPassword' -H 'Content-Type: application/x-www-form-urlencoded;charset=utf-8' -H 'Authorization: Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=' -X POST $authorizationServer/oauth/token)"
if [  show ]; then
	echo -e " Command: ${LRED}curl -s -d 'grant_type=password&username=john&password=123&client_secret=secret&scope=read&client_id=clientIdPassword' -H 'Content-Type: application/x-www-form-urlencoded;charset=utf-8' -H 'Authorization: Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=' -X POST $authorizationServer/oauth/token"
fi
if (( $? > 0 )); then
	echo " "
	echo "<<**********************************************************************************"
	echo "<< Retrieve the Access Token Failed!"
	echo "<<     Please, check if the Server is UP!"
	echo "<<**********************************************************************************"
	echo " "
	exit 113;
fi
echo -e "${HEADER}### -----> ${WHITE}Response:${NC}"
echo -e "${LBLUE}"
echo $jsonTokenAccess | jq .
echo ""
echo -e "${HEADER}### -----> ${WHITE}Access Token \"extracted\":${NC}"
tokenAccess="$(echo $jsonTokenAccess | jq values.access_token | tr -d '"' )" #'
echo -e "${LGREEN}$tokenAccess${NC}"

echo ""
echo ""

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> (2) ${WHITE}Check Granted Access Token at the Authorization Server: ${LGRAY}$authorizationServer/oauth/check_token${HEADER}"
echo -e "######################################################################################################################################${NC}"
jsonCheck="$(curl -s -X POST  --header 'Authorization: Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=' -d ''token=$tokenAccess'' $authorizationServer/oauth/check_token)"
if [  show ]; then
	echo -e " Command: ${LRED}curl -s -X POST  --header 'Authorization: Basic Y2xpZW50SWRQYXNzd29yZDpzZWNyZXQ=' -d 'token="$tokenAccess"' $authorizationServer/oauth/check_token"
fi
if (( $? > 0 )); then
	echo " "
	echo "<<**********************************************************************************"
	echo "<< Check Granted Access Token Failed!"
	echo "<<     Please, check if the Server is UP!"
	echo "<<**********************************************************************************"
	echo " "
	exit 113;
fi
echo -e "${HEADER}### -----> ${WHITE}Response:${NC}"
echo -e "${LBLUE}"
echo $jsonCheck | jq .

echo ""
echo ""

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> (3) ${WHITE}Using it with the Resource Server ${LGRAY}${resourceServer}/foos${WHITE} Token: ${LGREEN}$tokenAccess${HEADER}"
echo -e "######################################################################################################################################${NC}"
dataResult="$(curl -s --data 'id=1' -X POST ${resourceServer}/foos -H 'Authorization: Bearer '$tokenAccess'')"
if [  show ]; then
	echo -e " Command: ${LRED}curl -s --data 'id=1' -X POST ${resourceServer}/foos -H 'Authorization: Bearer $tokenAccess'"
fi
if (( $? > 0 )); then
	echo " "
	echo "<<**********************************************************************************"
	echo "<< Using the Token with the Resource Server Failed!"
	echo "<<     Please, check if the Server is UP!"
	echo "<<**********************************************************************************"
	echo " "
	exit 113;
fi
echo -e "${HEADER}### -----> ${WHITE}Response:${NC}"
echo -e "${LBLUE}"
echo $dataResult | jq .

echo ""
echo ""
echo -e "${LGRAY}--------->>> ${YELLOW}    ${LGRAY}<<<---------${NC}"
echo -e "${LGRAY}--------->>> ${YELLOW}${BOLD}${BLINK}OK! ${LGRAY}<<<---------${NC}"
echo -e "${LGRAY}--------->>> ${YELLOW}    ${LGRAY}<<<---------${NC}"
echo ""
echo ""
