def decimalToBinary(n): 
    return bin(n).replace("0b","")
def binaryToDecimal(n): 
    return int(n,2) 
    
num = 18
print("Original")
print(decimalToBinary(num))
while(num!=1):
    if(num%2==0):
        num=num//2
        print("Even Op")
        print(decimalToBinary(num))
    else:
        num+=1
        print("Odd Op")
        print(decimalToBinary(num))
