class MyQueue {
        public LinkL stackList;

        //Declare stack
        public MyQueue() {
                stackList = new LinkL();
        }

        //Push()
        public void push(String j) {
                stackList.insertLast(j);
        }

        //Pop()
        public String pop() {
                return stackList.deleteFirst();
        }

        //Display
        public void display() {
                stackList.displayList();
        }
 }





