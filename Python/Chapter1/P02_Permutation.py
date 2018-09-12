
# Check Permutation: 
# Given two strings, write a method to decide 
# if one is a permutation of the other.


def arePermutation(strA, strB):
    if len(strA) != len(strB):
        return False
    
    histagram = [0 for _ in range(128)]
    for chr in strA:
        chr = ord(chr)
        histagram[chr] += 1

    for chr in strB:
        chr = ord(chr)
        histagram[chr] -= 1
        if histagram[chr] < 0:
            return False
            
    return True

if __name__ == '__main__':
    tests = (('apple', "papel"), ("carrot", "tarroc"), ('hello', 'llloh'), ('banana', 'banaa'))
    for test in tests:
        print('%s %s - %s' % (test[0], test[1], arePermutation(test[0], test[1])))