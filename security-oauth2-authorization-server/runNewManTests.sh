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

# uid of the collection security-oath2 
uidCollection=1366272-f8713662-c1b1-4a44-afd5-3d3875dc13cc
# uid of dev enviroment
uidDevEnv=1366272-bb4bfe6f-43bb-4ffc-85c8-39a3bbbde5f0


if [ -z "$1" ]
  then
    echo -e "${LRED}===> Missing the API Key to access the PostMan's User Account${NC}"
    echo -e "syntax: runNewManTests {apiKey} {enviroment} {collection}"
    exit 113
fi
keyAPI=$1

echo -e "${HEADER}######################################################################################################################################"
echo -e "### -----> ${WHITE}Wait... launching the tests for ${LBLUE}security-oath2 ${WHITE}collection${HEADER}"
echo -e "######################################################################################################################################${NC}"

newman run "https://api.getpostman.com/collections/$uidCollection?apikey=$keyAPI" --environment "https://api.getpostman.com/environments/$uidDevEnv?apikey=$keyAPI" --color 
#--reporter-cli-no-summary