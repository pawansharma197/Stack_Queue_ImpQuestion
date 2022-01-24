class StockSpanner {
//greater on left
    public class Pair{
        int index,price;
        Pair(int price,int index){
            this.price=price;
            this.index=index;
        }
    }
    Stack<Pair> st;
    int time;
    public StockSpanner() {
        st=new Stack();
        time=0;
        st.push(new Pair(Integer.MAX_VALUE,-1));
    }
    
    public int next(int price) {
        Pair np=new Pair(price,time++);
        while(st.peek().price<=price){
            st.pop();
        }
        int ans=np.index-st.peek().index;
        st.push(np);
        return ans;
    }
}
