
class Node {
  String head;
  Node next;

  Node(String head, Node next) {
    this.head = head;
    this.next = next;
  }
  
  //static int lengthRec(Node l) { // non recursive fonction avec while
//	  int r = 0;
//	  while (l != null) {
//		  r+=1;
//		  l = l.next;
//	  }
//	  return r;
//  }

  
//Q1  
static int lengthRec(Node l) {
	if (l == null) {
		return 0;
	} else {
		return 1 + lengthRec(l.next);
	}
}
//

//Q2

static int length(Node l){
	int r = 0;
	for(Node cur = l; cur!= null; cur = cur.next) {
		r++;
	}
	return r;
}
//

//Q3

static String printNodes(Node l) {
	if (l == null) {
		return "[]";
	}
	String tab = "[";
	for(Node cur = l; cur!= null; cur = cur.next) {
		if (cur.next != null) {
		tab = tab + cur.head + ", ";
		} else {
			tab = tab + cur.head + "]";
		}
	}
	return tab;
}
//

//Q4

static void addLast(String s, Node l ) {
	while (l.next != null) {
		l = l.next;
	}
	l.next = new Node(s,null);
}
//

//Q5

static Node copy(Node the) {
	
	if(the == null) {
		return null;
	}
	
	Node fin = new Node(the.head,null);
	//Node prec = null;
	Node a = fin;
	
	while (the!= null) {
		if(the.next!=null) {
			a.next = new Node(the.next.head,null);
			//prec = a;
			the = the.next;
			a = a.next;
		} else {
			the = the.next;
		}
		
	}
	
	return fin;
}

//Node copy = new Node(the.head,the.next);
//the = the.next;
//copy = copy.next;
//while(the != null) {
//	copy = the;
//	the = the.next;
//	copy = copy.next;
//}

static Node insert(String s, Node l) {
	
	if(l == null) {
		return new Node(s,null);
	}
	
	if(s == null) {
		return l;
	}
	
	Node lc = l;
	Node prec = null;
	
	if ((l.head).compareTo(s)>0) {
		return new Node(s,l);
	}
	
	while (lc.next != null && (lc.head).compareTo(s)<0) {
		prec = lc;
		lc = lc.next;
	}
	
	if (lc.next == null) {
		if ((lc.head).compareTo(s)<0){
			if(prec == null) {
				l.next = new Node(s,null);
			} else {
				prec.next.next = new Node(s,null);
			}
			
			//if(prec.next!=null) {
			//	prec.next.next = new Node(s,null);
			//} else {
			//	l.next = new Node(s,null);
			//}
			
		} else {
			String a = lc.head;
			if (prec!=null) {
				prec.next = new Node(s,new Node(a,null));
			} else {
				l = new Node(s,new Node(a,null));
			}
			
		}
	} else {
		if(prec!=null) {
			prec.next = new Node(s,lc); // besoin de prec.next, sinon l = new Node(s, lc) change la place dans la memoire
		} else {
			l = new Node(s,lc);
		}
		
	}
	
	return l;
}

static Node insertionSort(Node l) {
	int size = length(l);
	
	Node n0 = new Node(l.head,null);
	l = l.next;
	
	//String min = l.head;
	
	for(int i=0;i<size-1;i++) {
		n0 = insert(l.head,n0);
		//System.out.println(l.head);
		l = l.next;
	}
	
	return n0;
}

//static Node merge(Node l1, Node l2) {
//	if(l1==null) {
//		return insertionSort(l2);
//	} else {
//		Node l0 = new Node(l1.head,l1.next);
//		while(l0.next!=null) {
//			l0=l0.next;
//		}
//		l0.next = l2;
//		return insertionSort(l1);
//	}
//}


  
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Node foobar = new Node("foo", new Node("bar", new Node("baz", null)));
		
		//System.out.println(lengthRec(foobar));
		
		//System.out.println(length(foobar));

		//System.out.println(printNodes(foobar));
		
		//addLast("a",foobar);
		
		//System.out.println(printNodes(foobar));
		
		//Node foo2 = copy(foobar);
		
		//System.out.println(printNodes(foo2));
		
		//System.out.println(printNodes(insert("bazz",foobar))); // bat, a
		
		//foobar = insert("foo",foobar);
		//System.out.println(printNodes(insertionSort(foobar)));
		//System.out.println(printNodes(insertionSort(foobar)));
		
		//Node b = copy(foobar);
		
		//System.out.println(printNodes(b));
		
	}

}
