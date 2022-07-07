
public class Prefix {
	
	String[] t;
	
	final static String start = "<START>", end = "<END>", par = "<PAR>";
	
	Prefix(int n){
		this.t = new String[n];
		for(int i=0;i<n;i++) {
			this.t[i] = start;
		}
	}
	
	static boolean eq(Prefix p1, Prefix p2) {
		int t1 = (p1.t).length;
		int t2 = (p2.t).length;
		
		if(t1!=t2) {
			return false;
		} else {
			boolean b0=true;
			for (int i=0;i<t1;i++) {
				if (!(p1.t[i].equals(p2.t[i]))){
					b0=false;
				}
			}
			return b0;
		}
	}
	
	Prefix addShift(String w) {
		int tai = this.t.length;
		Prefix toretfin = new Prefix(tai);
		toretfin.t[tai-1] = w;
		for(int i=0;i<tai-1;i++) {
			toretfin.t[i] = this.t[i+1];
		}
		return toretfin;
	}
	
	public int hashCode() {
		int h=0;
		for(int i=0;i<t.length; i++) {
			int add = t[i].hashCode();
			h = 37*h + add;
		}
		return h;
	}
	
	int hashCode(int n) {
		int a = (this.hashCode())%n;
		if (a>=0) {
			return a;
		} else {
			return a+n;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
