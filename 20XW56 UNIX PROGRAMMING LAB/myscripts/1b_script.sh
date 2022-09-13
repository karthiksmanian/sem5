f=`ls -l|grep -i ^-.*|wc -l`
d=`ls -l|grep -i ^d.*|wc -l`


echo "Type of files             Count"
echo "Regular files             $f"
echo "Directories               $d"
