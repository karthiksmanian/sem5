BEGIN{
FS="|"
}
{
dept[$3]+=$7
count[$3]+=1
}
END{
for (x in dept)
	print x,dept[x]/count[x]

}
