
    # Is Unique: 
    # Implement an algorithm to determine if a string has all unique characters. 
    # What if you cannot use additional data structures?

def isUnique(word):
    
    if len(word) > 128:
        return False

    setvecotr = [False for _ in range(128)]
    for chr in word:
        chr = ord(chr)
        if setvecotr[chr]:
            return False
        setvecotr[chr] = True

    return True

def isUniqueNoDataStructure(word):

    bitvector = 0
    
    for chr in word:
        chr = ord(chr) - ord('a')
        if (bitvector & (1 << chr)) > 0:
            return False
        bitvector |= (1 << chr)
        
    return True


if __name__ == "__main__":
    words = ["abcde", "hello", "apple", "kite", "padle"]

    for word in words:
        print('%s %s' % (word, isUnique(word)))

    for word in words:
        print('%s %s' % (word, isUniqueNoDataStructure(word)))
