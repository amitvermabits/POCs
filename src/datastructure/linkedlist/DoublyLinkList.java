package datastructure.linkedlist;

public class DoublyLinkList {
	int size = 0;
	DoublyLinkedListNode start;
	DoublyLinkedListNode end;

	DoublyLinkedListNode insertNodeBeginning(int data) {
		if (size == 0) {
			DoublyLinkedListNode node = new DoublyLinkedListNode();
			node.data = data;
			node.left = null;
			node.right = null;
			size++;
			start = node;
			end = node;
			return start;
		}

		DoublyLinkedListNode node = new DoublyLinkedListNode();

		node.data = data;
		node.right = start;
		node.left = null;
		start = node;
		size++;
		return start;

	}

	DoublyLinkedListNode insertAtEnd(int data) {
		
		System.out.println("insertAtEnd size:"+size);
		if (size == 0) {
			
			
			DoublyLinkedListNode node = new DoublyLinkedListNode();
			node.data = data;
			node.left = null;
			node.right = null;
			size++;
			start.left=node;
			start = node;
			end = node;
			return start;
		}

		DoublyLinkedListNode node = new DoublyLinkedListNode();

		node.data = data;
		node.right = null;
		node.left = end;
		end.right=node;
		end = node;
		size++;
		return end;

	}
	
	void insertAtPosition(int data,int pos){
		if(size < pos){
			System.out.println("can not insert at given position");
			return;
		}
		System.out.println("size :" + size);
		/*if(pos == size){
			insertAtEnd(data);
			return;
		}*/
		DoublyLinkedListNode ptr = start;
		int incrementer =1;
		while((incrementer +1) != pos){
			ptr =ptr.right;
			incrementer++;
		}
		//System.out.println("position data :" + ptr.data);
		DoublyLinkedListNode doublyLinkedListNode = new DoublyLinkedListNode();
		doublyLinkedListNode.data=data;
		doublyLinkedListNode.right=ptr.right;
		doublyLinkedListNode.left=ptr;
		ptr.right=doublyLinkedListNode;
		size++;
	}
	
	void display(){
		DoublyLinkedListNode ptr = start;
		while(ptr != null){
			System.out.print("," + ptr.data);
			ptr=ptr.right;
		}
	}
	
	public static void main(String[] args) {
		DoublyLinkList doublyLinkList = new DoublyLinkList();
		doublyLinkList.insertNodeBeginning(1);
		doublyLinkList.insertAtEnd(3);
		doublyLinkList.insertAtPosition(2, 2);
		doublyLinkList.insertAtEnd(5);
		doublyLinkList.insertAtPosition(4, 4);
		doublyLinkList.display();
	}
	

}
