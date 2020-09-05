
#ifndef STACK_H_
#define STACK_H_

template <typename T> class StackNode {
public:
	StackNode(const T value, StackNode<T>* next);
	const T getValue();
	StackNode<T>* getNext();
	static int getNodeCount();
private:
	T value;
	StackNode<T>* next;
	static int nodeCount;
};

template <typename T = int> class Stack {
public:
	Stack();
	virtual ~Stack();
	void push(const T& value);
	const T pop();
private:
	StackNode<T>* top;
};




#endif /* STACK_H_ */
