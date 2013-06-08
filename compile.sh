
temp_count=`git status | grep "Changes not staged for commit" | wc -l`
if [ "${temp_count}" != "0" ]; then
  echo "------error : Changes not staged for commit"
  exit
fi


git pull 

ant clean
ant
