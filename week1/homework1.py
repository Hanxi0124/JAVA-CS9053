#The first two lines are used to import the radom library of python which is used to randomly
#pick a number from the given options
import random
from random import randint
import sys

no_of_heap=0
x =0
goto=0
p=1
def printmethod(a):
    t=""
    t=t+" ".join(str(x) for x in a)
    return t


#This is a function definition. Here, I create the heap of ranom size and assign a random value
#9,11 or 13 to it
def board():
    no_of_heap_choice=[3,5,7]
    no_of_object_choice=[9,11,13]
    no_of_heap=random.choice(no_of_heap_choice)
    for x in range(1,no_of_heap+1): #randomly assign the value to each heap which is the size of the heap
        no_of_object=random.choice(no_of_object_choice)
        heap.append(no_of_object) #randomly assign the object number to the heap
    print "Created",no_of_heap,"heaps of sizes",printmethod(heap)
    sys.stdout.flush()

#this module takes the power of the number in the train module. Meaning, the first is powered with the next
#number. The resulting number is powered with the third number and so on. this way, it is reduced to 1 number.
def narrow():
    return reduce(lambda x,y: x^y, heap)

def win():
    return [x^narrow() < x for x in heap].index(True)

#This module defines the concept of user move. Ask for the number of object and the heap position to which the
#the number of object is to be reduced.

def humanMove():
    print "Player human enter the number of objects (Y) to take from what heap (X)- in order: Y X"
    sys.stdout.flush()
    #y, x = raw_input().split() or 'a' 'b'


    numbers = map(str, raw_input().split())
    if (len(numbers)==2):
        checking1=numbers[0]
        checking2=numbers[1]
        try:
            val = int(checking2)
        except ValueError:
            print "Player human that is an invalid move, try again"
            humanMove()

        try:
            val = int(checking1)
        except ValueError:
            print "Player human that is an invalid move, try again"
            humanMove()

    if (len(numbers)==2 and int(numbers[0])>0 and int(numbers[1])>0):
        y=int(numbers[0])
        x=int(numbers[1])
        if (x>len(heap)):
            print "Player human that is an invalid move, try again" #fine
            humanMove()
        if (y>heap[x-1]):
            print "Player human that is an invalid move, try again" #fine
            humanMove()
    else:
        print "Player human that is an invalid move, try again" #everything fine here
        humanMove()
    x = x-1;
    #try:
        #if x <= -1: raise #throws exception if the user provides the heap number which doesnot exist
    if y>0 and y<=heap[x]: #makes sure the object size provided is within the limit of the actual number of obj
        heap[x]-=y    #deduct the object from the heap
        print printmethod(heap)
        sys.stdout.flush()

    else:
    #    print printmethod(heap)
    #    sys.stdout.flush() #print this way to remove the bracket from the list
            #print "Player human that is an invalid move, try again"
            #sys.stdout.flush()
        goto=1
    #except:
        #print printmethod(heap)
        #sys.stdout.flush()
        #print "Player human that is an invalid move, try again"
        #sys.stdout.flush()
        #humanMove()
    if isOver(): print "Player human has won"

def computerMove():
    if narrow()==0:
        tem=max(heap)
        h=heap.index(tem)
        to_be_reduced=randint(1,max(heap))
        heap[heap.index(max(heap))]-=to_be_reduced
        print "Player computer took",to_be_reduced, "objects from heap",h
        sys.stdout.flush()
    else:
        temp=win()
        temporary=heap[temp]
        heap[temp]^=narrow()
        temp1=temporary-heap[temp]
        print "Player computer took",temp1, "objects from heap",(temp+1)
        sys.stdout.flush()
    print printmethod(heap)
    sys.stdout.flush()
    if isOver(): print "Player computer has won"

# this module make sure there is no obkect left in any of the heap which mark the end of the game.
def isOver():
    return all(z == 0 for z in heap) #this to return true, all the elements of the heap should be 0.

heap = []
board()

turn=random.randint(1,2) #These number corresponds to the module humanMove and computerMove
if goto==1:
    turn=2
    p=0
if (turn==1): #These blocks of statement starts the game with human as the first player and then continue
    print "Player human goes first"
    sys.stdout.flush()
    while True:
        humanMove()
        if isOver(): break
        computerMove()
        if isOver(): break
elif (turn==2): #These blocks of statement starts the game with computer as the first player and then continue
    if p==1:
        print "Player computer goes first"
        sys.stdout.flush()
    while True:
        computerMove()
        if isOver(): break
        humanMove()
        if isOver(): break
