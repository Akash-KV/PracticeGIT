#!/bin/bash

# Variables
TEST=false
MBT=/root/model-based-testing/mbt-12-build-mode/qa/qa-automation/model-based-testing/mbt-ie/Model_Repository/Dna_ItembankX_Suite
LOGS=${MBT}/logs
current_time=$(date '+%m.%d.%Y-%I.%M%p')
COUNTER=0
URL=https://hooks.slack.com/services/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

RED='\033[0;31m'
LGREEN='\033[0;32m'
NC='\033[0m'
LGREEN='\033[1;32m'

# Go to mbt directory and create a logs file
cd ${MBT}
mkdir ${LOGS}/${current_time}

# Run test function
run_test() {
  CWD=${pwd}
  cd $PWD/$1
  test=$1
  printf '%s\n' "${PWD##*/} is running..."
  mvn graphwalker:test >> ${LOGS}/${current_time}/${PWD##*/}.txt
  DATA=$(python ../log_parser.py -l ${LOGS}/${current_time}/${PWD##*/}.txt)
  python ../log_parser.py -l ${LOGS}/${current_time}/${PWD##*/}.txt
  if python ../log_parser.py -l ${LOGS}/${current_time}/${PWD##*/}.txt | grep -q 'ERROR'; then
    printf "${RED} ==> ${1} Failed.\n ${NC}";
    curl -X POST -H 'Content-type: application/json' --data "{'text': '*[12-BUILD-MODE] $current_time*'}" ${URL}
    curl -X POST -H 'Content-type: application/json' --data "{'text': '\`❌ $test\`'}" ${URL}
    curl -X POST -H 'Content-type: application/json' --data "{'text':'$DATA'}" ${URL}
  fi
  if [[ "$?" -ne 0 ]] ; then
        printf "${RED} ==> ${1} Failed.\n ${NC}";
        curl -X POST -H 'Content-type: application/json' --data "{'text': '*[12-BUILD-MODE]  $current_time*'}" ${URL}
        curl -X POST -H 'Content-type: application/json' --data "{'text': '\`❌ $test\`'}" ${URL}
        curl -X POST -H 'Content-type: application/json' --data "{'text':'$DATA'}" ${URL}
 fi
  if cat ${LOGS}/${current_time}/${PWD##*/}.txt | grep -q 'FAILURE'; then
    printf "${RED} ==> ${1} Failed.\n ${NC}";
    curl -X POST -H 'Content-type: application/json' --data "{'text': '*[12-BUILD-MODE] $current_time*'}" ${URL}
    curl -X POST -H 'Content-type: application/json' --data "{'text': '\`❌ $test\`'}" ${URL}
    curl -X POST -H 'Content-type: application/json' --data "{'text':'$DATA'}" ${URL}
  fi
  if [[ "$?" -ne 0 ]] ; then
        printf "${RED} ==> ${1} Failed.\n ${NC}";
        curl -X POST -H 'Content-type: application/json' --data "{'text': '*[12-BUILD-MODE]  $current_time*'}" ${URL}
        curl -X POST -H 'Content-type: application/json' --data "{'text': '\`❌ $test\`'}" ${URL}
        curl -X POST -H 'Content-type: application/json' --data "{'text':'$DATA'}" ${URL}
  else
        printf "${LGREEN} ==> ${1} Passed..\n ${NC}"
  fi
  cd ..
}

# --------------Test run--------------
printf "${RED} ==> Testing has begun\n ${NC}"
start=`date +%s`

run_test Ibx_BuildMode_ExtraCredit &
wait
run_test Ibx_BuildMode_MassApply &
wait
run_test Ibx_BuildMode_QuestionGroup &
wait
run_test Ibx_BuildMode_Standards &
wait
run_test Ibx_BuildMode_SingleItemPassageRemove &
wait
run_test Ibx_BuildMode_Back
wait

end=`date +%s`
runtime=$((end-start))
printf "${LGREEN} \n==> Done. ${NC}"
# --------------End run--------------

curl -X POST -H 'Content-type: application/json' --data "{'text': '*[12-BUILD-MODE | DONE] $current_time*'}" ${URL}
curl -X POST -H 'Content-type: application/json' --data '{"text":"Runtime: '$runtime' secs"}' ${URL}