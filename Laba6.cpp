#include <iostream>
using namespace std;
// Реализация узла
struct ListElem {
	string value;
	ListElem* next;

	ListElem(string _value) : value(_value), next(nullptr) {}
};

struct list {

	ListElem* first;
	ListElem* last;
	// Указатели на 1 и последний узлы + конструктор
	list() : first(nullptr), last(nullptr) {}

	// Функция проверки наличия узлов в списке
	bool is_empty() {
		return first == nullptr;
	}

	// Функция добавления элемента в конец списка
	void pushBack(string _value) {
		ListElem* p = new ListElem(_value);
		if (is_empty()) {
			first = p;
			last = p;
			return;
		}
		last->next = p;
		last = p;
	}

	//Функция печати всего списка
	void print() {
		if (is_empty()) 
			return;
		ListElem* p = first;
		while (p) {
			cout << (p->value) << " ";
			p = p->next;
		}
		cout << endl;
	}
};

int main() {
	list l;
	cout << l.is_empty() << endl;
	l.pushBack("5");
	l.pushBack("90");
	l.pushBack("12");
	l.pushBack("17");
	cout << l.is_empty() << endl;
	l.print();
	return 0;
}
