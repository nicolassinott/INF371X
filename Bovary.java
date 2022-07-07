
public class Bovary {

	
	static HMap buildTable (String[] files, int n) {
		HMap a = new HMap();
		int len = files.length;

		for(int k=0;k<len;k++) {
			
			boolean b0 = true;
			WordReader fileRead = new WordReader(files[k]);
			Prefix P = new Prefix(n);
			
			while(b0) {
				String b = fileRead.read();
				if (b==null) {
					b0 = false;
				} else {
					a.add(P, b);
					P = P.addShift(b);
				}
			}
			a.add(P, "<END>");
		}
		return a;
	}
	
	static void generate(HMap t, int n) {
		Prefix P = new Prefix(n);
		//int nh = t.t.length;
		
		boolean b0 = true;
		
		while(b0) {
			//int h = P.hashCode(nh);
			//int count = 0;
			//if(t.t[h]==null||t.t[h].head==null) {
			//	System.out.println("");
			//	break;
			//}
			
			//EntryList cl = new EntryList(t.t[h].head, t.t[h].next);
			//while(cl!=null) {
			//	count++;
			//	cl = cl.next;
			//}
			//double u = Math.random();
			//int chosenInt = (int)(count*u);
			
			//EntryList cl2 = new EntryList(t.t[h].head, t.t[h].next);
			WordList cl2 = t.find(P);
			//for(int j=0;j < chosenInt;j++) {
			//	cl2 = cl2.next;
			//}
			
			//chosenInt = (int)(cl2.head.value.length()*Math.random());
			int chosenInt = (int)(cl2.length()*Math.random());
			//w = cl2.head.value.toArray()[chosenInt];
			String w = cl2.toArray()[chosenInt];
			P = P.addShift(w);
			
			if(w.equals("<PAR>")) {
				System.out.println();
			} else {
				if(w == "<END>") {
					System.out.println();
					b0=false;
				} else {
					System.out.println(w+" ");
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int n = 3;
		HMap t = new HMap(3);
		String[] a = new String[35];
		for(int i=0;i<35;i++) {
			
			String b = "bovary/";
			if(i<9) {
				String c = "0"+Integer.toString(i+1);
				String d = b+c+".txt";
				a[i] = d;
			} else {
				String c = Integer.toString(i+1);
				String d = b+c+".txt";
				a[i] = d;
			}
		}
		
		t = buildTable(a, n);
		generate(t, n);
		
		//a[0] = "bovary/01.txt";
		//a[1] = "bovary/01.txt";
		
		//t = buildTable(a, n);
		
		
		//generate(t, n);

	}

}
