BEGIN{
FS = "|"
}
{
	if($5>=7&&$5<=9)
	{
		print $0;
	}
}
END{
}
