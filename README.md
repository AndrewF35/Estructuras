# Data structures

This repository works as guide for the Data structure students of the **Universidad Nacional de Colombia**, where the most important data structures are implemented from scratch using **Java** programming language.

## Table of Contents
- [Sequential data structures](#sequential-data-structures)
  - [ArrayList](#arraylist)
  - [LinkedListList](#linkedlist)
    - [Singly LinkedList](#singly-linkedlist)
    - [Doubly LinkedList](#doubly-linkedlist)
  - [Stack](#stack)
    - [ArrayStack](#arraystack)
    - [LinkedListStack](#linkedliststack)
  - [Queue](#queue)
    - [LinkedListQueue](#linkedlistqueue)

# Sequential data structures

## ArrayList
Resizable one-dimensional array, where all the elements are store in contiguous memory, the implementation was done using generics and static array and doubling the space when is needed. 

## LinkedList
Dynamic one-dimensional list, where all the elements are stored in random memory and accessed through pointer, the list is implemented using two points one called head which points to the first element and another called tail which points to the last element.

### Singly LinkedList
Implemented with only one pointer to next element, the next for the last element points to null.

### Doubly LinkedList
Implemented with two one pointer to next element and another to previous one, the next element of the last element points to null and the previous element of the first element points to null too.

## Stack
Data structure, which serve the elements as **LIFO** order (Last In, First Out)

### ArrayStack
Implementation of a stack using a static array

### LinkedListStack
Implementation of a stack using a singly LinkedList

## Queue
Data structure, which serve the elements as **FIFO** order (First In, First Out)

### LinkedListQueue
Implementation of a queue using a singly LinkedList 