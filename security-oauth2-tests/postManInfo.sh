#!/bin/bash
##
## PostMan communication
## https://docs.api.getpostman.com/
##

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
NOT_BLINK='\e[25m'

if [ -z "$1" ]
  then
    echo -e "${LRED}Need the API Key to access the PostMan Collection's User${NC}"
    exit 113
fi
keyAPI=$1

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> ${WHITE}All My Enviroments${HEADER}"
echo -e "######################################################################################################################################${NC}"
echo -e "${LBLUE}"
jsonMyCollection=$(curl -s --request GET   --url https://api.getpostman.com/environments   --header "X-Api-Key: $keyAPI")
echo $jsonMyCollection | jq .
echo -e "${NC}"

echo ""
echo ""

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> ${WHITE}All My Collection${HEADER}"
echo -e "######################################################################################################################################${NC}"
echo -e "${LBLUE}"
jsonMyCollection=$(curl -s --request GET   --url https://api.getpostman.com/collections   --header "X-Api-Key: $keyAPI")
echo $jsonMyCollection | jq .
echo -e "${NC}"

echo ""
echo ""

#Create a flat string with all the Collections Ids separated by spaces (coming from the JSON Object)
strCollectionIds=$(echo ${jsonMyCollection} | jq -r --compact-output --raw-output '{id:.collections[].id} | .id' | sed 's/\\n/\n/g;')
#Create an Array from this flat string of Collections Ids
arrayCollectionIds=($strCollectionIds)
#The same for its names (if I wanna use them, in case)
strCollectionNames=$(echo ${jsonMyCollection} | jq -r --compact-output --raw-output '{name:.collections[].name} | .name' | sed 's/\\n/\n/g;')
arrayCollectionNames=($strCollectionNames)
index=0
for i in "${arrayCollectionIds[@]}"
do
   echo -e "${HEADER}######################################################################################################################################"
   echo -e "### -----> ${WHITE}List The Collection:$i  ${LGREEN}${arrayCollectionNames[index]} ${HEADER}"
   echo -e "######################################################################################################################################${NC}"
   echo -e "${LBLUE}"
   curl -s --request GET   --url https://api.getpostman.com/collections/$i  --header "X-Api-Key: $keyAPI" | jq .
   echo -e "${NC}"
   index=$index+1
done


echo ""
echo ""
echo "end..."
echo ""

# List Enviroments
# curl -s --request GET --url https://api.getpostman.com/environments --header 'X-Api-Key: $apiKey' | jq .

# Using Newman (installed via npm - Cli Command for PostMan) 
# newman run "https://api.getpostman.com/collections/1366272-f8713662-c1b1-4a44-afd5-3d3875dc13cc?apikey=$apiKey" --environment "https://api.getpostman.com/environments/1366272-bb4bfe6f-43bb-4ffc-85c8-39a3bbbde5f0?apikey=$apiKey"


