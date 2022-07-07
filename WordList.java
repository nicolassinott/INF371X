
public class WordList {
	Node content;
	
	WordList(){
		content = null;
	}
	
	WordList(String[] t){
		content = null;
		for(int i=0;i<t.length;i++) {
			this.addLast(t[i]);
		}
	}
	
	//static void write(WordList a, Node b) {
	//	a.content = b;
	//}
	
	static WordList foobar = new WordList();
	static {foobar.content = new Node("foo", new Node("bar", new Node("baz", null))); };
	
	int length(){
		return Node.length(this.content);
	}
	
	String print() {
		return Node.printNodes(this.content);
	}
	
	
	void addFirst(String w) {
		this.content = new Node(w,this.content);
	}
	
	void addLast(String w) {
		if (this.content == null){
			this.content = new Node(w,null);
		} else {
			Node a = this.content;
			Node prec = null;
			
			while (a!= null) {
				prec = a;
				a = a.next;
			}
			prec.next = new Node(w,null);
		}
	}
	
	String removeFirst() {
		if (this.content == null) {
			return null;
		}
		String toreturn = this.content.head;
		this.content = this.content.next;
		return toreturn;
	}
	
	String removeLast() {
		if(this.content == null) {
			return null;
		} else {
			Node a = this.content;
			Node prec = null;
			
			while (a.next != null) {
				prec = a;
				a = a.next;
			}
			
			if(prec != null) {
				String toreturn = a.head;
				prec.next = null;
				return toreturn;
			} else {
				String toreturn = a.head;
				this.content = null;
				return toreturn;
			}
		}
	}
	
	void insert(String s) {
		if(this.content == null) {
			this.content = new Node(s,null);
		} else {
			this.content = Node.insert(s, this.content);
		}
	}
	
	void insertionSort() {
		if(this.content != null) {
			this.content = Node.insertionSort(this.content);
		} 
	}
	
	//void mergeSort() {
	//	this.content = Node.me
	//}
	
	String[] toArray() {
		if (this.content == null) {
			String[] a = new String[0];
			return a;
		} else {
			int t = Node.length(this.content);
			String[] tab = new String[t];
			
			Node a=this.content;
			
			for (int i = 0; i<t;i++) {
				tab[i] = a.head;
				a = a.next;
			}
			return tab;
		}
	}
	
	
	
	
	
	//foobar.content = new Node("foo", new Node("bar", new Node("baz", null)));

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}

}
