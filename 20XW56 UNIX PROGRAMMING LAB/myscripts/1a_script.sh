arg=$1
echo $arg
a=`cat usernames`

arr=()
ct=0
f=0
for w in $a
do
        arr[$ct]=$w
        ct=$(($ct+1))
done
for n in "${arr[@]}"
do
        if [ $n == arg ]
        then

                f=1
                break;
        fi

done
echo $f
if [ $f == 1 ]
then
        echo "username already exists"
fi

if [ $f == 0 ]
then
        $1 >> usernames
fi

