
def main():
	n=positive()
	coins = [25,10,5,1]
	count=0
	t=int(n)
	if n-int(n)==0.0:
		n=((n -t)*100)
	elif n>1:
		n=((n -t)*100)+1
	else:
		n=((n -t)*100)
	for i in coins:
	    count += int(n/i)
	    n = n%i
	print(count)
def positive():
	n = float(input('O hai! How much change is owed?\n'))
	while n<0.0:
		n = float(input('O hai! How much change is owed?\n'))
	return n
if __name__=="__main__":
	main()
