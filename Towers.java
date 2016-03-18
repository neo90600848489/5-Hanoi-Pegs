6	package Hanoi; 
7	import java.util.Scanner; 
8	public class Towers { 
9	    private Scanner in; 
10	    private int n,current,r; 
11	    private int[] hasItMoved,toDest; 
12	    Towers(){ 
13	        this.in=new Scanner(System.in); 
14	        this.current=1; 
15	        System.out.println("Enter the number of disks: "); 
16	        this.n = in.nextInt(); 
17	        this.hasItMoved=new int[12]; 
18	        this.toDest=new int[12]; 
19	        for(int j=0;j<this.toDest.length;j++) 
20	            this.toDest[j]=1; 
21	        for(int i=1;i<=n;i++) 
22	            this.toDest[i]=0; 
23	        r=n; 
24	        hanoiStart(n,"Start","Aux1","Aux3","Aux2","Dest",this.current);}   
25	  
26	   public void hanoiStart(int numOfDisks, String Start ,String source, String dest, String aux, String last, int current){ 
27	       move(1, Start, source, this.current); this.current++; 
28	       H1(n,"Start","Aux1","Aux3","Aux2","Dest",this.current); 
29	       move(1, dest, last, this.current); this.current++; 
30	   } 
31	   
32	   public int H1(int numOfDisks, String Start ,String source, String dest, String aux, String last, int current) { 
33	    if (numOfDisks == 1) { 
34	        move(numOfDisks, source, aux, this.current); this.current++; 
35	        move(numOfDisks, aux, dest, this.current); this.current++; 
36	    } else if (numOfDisks == 2) { 
37	        move(numOfDisks-1, source, aux, this.current); this.current++; 
38	        move(numOfDisks-1, aux, dest, this.current); this.current++; 
39	        if(this.current==4) 
40	        { move(numOfDisks, Start, source, this.current); this.current++;} 
41	        move(numOfDisks, source, aux, this.current); this.current++; 
42	        move(numOfDisks-1, dest, aux, this.current); this.current++; 
43	        move(numOfDisks-1, aux, source, this.current); this.current++; 
44	        move(numOfDisks, aux, dest, this.current); this.current++; 
45	        if(this.r==2) 
46	        {move(2, dest, last, this.current); this.current++;} 
47	        move(numOfDisks-1, source, aux, this.current); this.current++; 
48	        move(numOfDisks-1, aux, dest, this.current); this.current++; 
49	        
50	    } else if (numOfDisks > 2) {         
51	        this.current = H1(numOfDisks-1, Start, source, dest, aux,last, this.current); 
52	        if(this.hasItMoved[numOfDisks]!=1) 
53	        {move(numOfDisks, Start, source, this.current); this.current++;this.hasItMoved[numOfDisks]=1;} 
54	        move(numOfDisks, source, aux, this.current); this.current++;         
55	        this.current = H1(numOfDisks-1,Start, dest, source, aux,last, this.current); 
56	        move(numOfDisks, aux, dest, this.current); this.current++; 
57	        if(this.toDest[numOfDisks+1]!=0) 
58	        {move(numOfDisks, dest, last, this.current); this.current++;this.toDest[numOfDisks]=1;} 
59	        if(numOfDisks==r) 
60	        this.r--; 
61	        this.current = H1(numOfDisks-1, Start,source, dest, aux,last, this.current); 
62	        }; 
63	    return this.current; 
64	}
65	public void move(int aDisk, String source, String dest, int currentStep) { 
66	    System.out.println("Move " + this.current + ": Move disk " + aDisk + " from " + source + " to " + dest);} 
