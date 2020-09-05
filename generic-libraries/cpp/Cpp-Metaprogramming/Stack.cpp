
#include "Stack.h"

template <typename T> Stack<T>::Stack() {
	top = 0;
}

template <typename T> Stack<T>::~Stack() {
	while(top) {
		pop();
	}
}

template <typename T> void Stack<T>::push(const T& value) {
	top = new StackNode<T>(value, top);
}

template <typename T> const T Stack<T>::pop() {
	if(top) {
		auto next = top->getNext();
		auto value = top->getValue();
		delete top;
		top = next;
		return value;
	}
	throw "Invalid use of stack, top is null";
}

template <typename T> StackNode<T>::StackNode(const T value, StackNode<T>* next) {
	this->value = value;
	this->next = next;
	nodeCount++;
}


template <typename T> const T StackNode<T>::getValue() {
	return value;
}

template <typename T> StackNode<T>* StackNode<T>::getNext() {
	return next;
}

template <typename T> int StackNode<T>::nodeCount = 0;

template <typename T> int StackNode<T>::getNodeCount() {
	return nodeCount;
}



