BEGIN{
FS="|"
sum = 0
}
{
if($7>0){
 sum+=$7
}
}
END{
print sum
}
