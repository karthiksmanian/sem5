BEGIN{
FS="|"
}
{
if(NR>1 && NR<5){
	print $1"   "$3 $7
}
}
END{
}
