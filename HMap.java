
public class HMap {
	
	EntryList[] t;
	
	int nbEntries;
	
	HMap(int n){
		this.nbEntries = 0;
		this.t = new EntryList[n];
	}
	
	HMap() {
		this.nbEntries = 0;
		this.t = new EntryList[20];
	}
	
	WordList find(Prefix key) {
		if (this.nbEntries == 0) {
			return null;
		} else {
			int a = key.hashCode((this.t).length);
			if (this.t[a] == null){
				return null;
			} else {
				EntryList c = this.t[a];
				while(c!=null) {
					if(Prefix.eq(c.head.key,key)) {
						return c.head.value;
					}
					c = c.next;
				}
				return null;
			}
		}
	}
	
	void addSimple(Prefix key, String w) {
		if (this.nbEntries == 0) {
			this.nbEntries ++;
			int a = key.hashCode((this.t).length);
			
			String [] b;
			b = new String[1];
			b[0] = w;
			WordList c = new WordList(b);
			
			Entry d = new Entry(key,c);
			
			this.t[a] = new EntryList(d,null);
		} else {
			if (this.find(key) == null) {
				this.nbEntries ++;
				int a = key.hashCode((this.t).length);
				
				String [] b;
				b = new String[1];
				b[0] = w;
				WordList c = new WordList(b);
				
				Entry d = new Entry(key,c);
				
				this.t[a] = new EntryList(d,this.t[a]);
			} else {
				WordList a = find(key);
				
				a.addLast(w);
				
			}
		}
	}
	
	void rehash(int n) {
		//HMap novo = this;
		HMap novo = new HMap(n);
		int nold = this.t.length;
		
		novo.t = new EntryList[n];
			
		//this.t = new EntryList[n];
		novo.nbEntries = 0;
		
		for (int i=0 ; i < nold ; i++) {
			EntryList a = this.t[i];
			while (a!=null) {
				int h = a.head.key.hashCode(n);
				novo.t[h] = new EntryList(a.head,novo.t[h]);
				novo.nbEntries++;
				a = a.next;
				//Node b = old.t[i].head.value.content;
				//while (b!=null) {
				//	this.addSimple(Prefix key, String w)
				//}		
			}
		}
		
		this.t = novo.t;
		
	}
	
	void add(Prefix key, String w) {
		if(this.find(key) == null && this.nbEntries+1 > (3*(this.t.length))/4) {
			int a = this.t.length;
			this.rehash(2*a);
			this.addSimple(key, w);
		} else {
			this.addSimple(key, w);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//HMap a = new HMap(5);
		//EntryList t = new EntryList(new Entry(new Prefix(2),new WordList()),new EntryList(new Entry(new Prefix(2),new WordList()),null));
		//EntryList u = new EntryList(new Entry(new Prefix(2),new WordList()),new EntryList(new Entry(new Prefix(2),new WordList()),null));
		//a.t[0] = t;
		//a.t[1] = u;
		
		//System.out.println(a.t.length);
		

	}

}
