package wb;

import java.util.Scanner;

/**
 * @author 王波
 */
public class huffmanTree {
    // 建立数的节点类
    static class Node {
        public int weight;//频数
        public int parent;
        public int leftChild;
        public int rightChild;

        // 空参构造器
        public Node() {

        }

        //通过权值，父亲节点，左右孩子节点构造
        public Node(int weight, int parent, int leftChild, int rightChild) {
            this.weight = weight;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        void setWeight(int weight) {
            this.weight = weight;
        }

        void setParent(int parent) {
            this.parent = parent;
        }

        void setLeftChild(int leftChild) {
            this.leftChild = leftChild;
        }

        void setRightChild(int rightChild) {
            this.rightChild = rightChild;
        }

        int getWeight() {
            return weight;
        }

        int getParent() {
            return parent;
        }

        int getLeftChild() {
            return leftChild;
        }

        int getRightChild() {
            return rightChild;
        }
    }

    //新建哈夫曼编码
    static class NodeCode {
        String character;   //节点的名称
        String code;        //存储哈夫曼编码

        NodeCode(String character, String code) {
            this.character = character;
            this.code = code;
        }

        NodeCode(String code) {
            this.code = code;
        }

        void setCharacter(String character) {
            this.character = character;
        }

        void setCode(String code) {
            this.code = code;
        }

        String getCharacter() {
            return character;
        }

        String getCode() {
            return code;
        }
    }

    //初始化一个Huffman树
    public static void initHuffmanTree(Node[] huffmanTree, int m) {
        for (int i = 0; i < m; i++) {
            huffmanTree[i] = new Node(0, -1, -1, -1);
        }
    }

    //初始化一个huffmanCode
    public static void initHuffmanCode(NodeCode[] huffmanCode, int n) {
        for (int i = 0; i < n; i++) {
            huffmanCode[i] = new NodeCode("", "");
        }
    }

    //获取huffmanCode的符号
    public static void getHuffmanCode(NodeCode[] huffmanCode, Node[] huffmanTree, int n) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            String temp = input.next();
            huffmanCode[i] = new NodeCode(temp, "");
            huffmanTree[i] = new Node(Integer.parseInt(temp), -1, -1, -1);
        }
    }

    //获取huffman树节点频数
    public static void getHuffmanWeight(Node[] huffmanTree, int n) {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            int temp = input.nextInt();
            huffmanTree[i] = new Node(temp, -1, -1, -1);
        }
    }

    //从n个结点中选取最小的两个结点
    public static int[] selectMin(Node[] huffmanTree, int n) {
        int[] min = new int[2];
        class TempNode {
            int newWeight;//存储权
            int place;//存储该结点所在的位置

            TempNode(int newWeight, int place) {
                this.newWeight = newWeight;
                this.place = place;
            }

            void setNewWeight(int newWeight) {
                this.newWeight = newWeight;
            }

            void setPlace(int place) {
                this.place = place;
            }

            int getNewWeight() {
                return newWeight;
            }

            int getPlace() {
                return place;
            }
        }

        TempNode[] tempTree = new TempNode[n];

        //将huffmanTree中没有双亲的结点存储到tempTree中
        int i, j = 0;
        for (i = 0; i < n; i++) {
            if (huffmanTree[i].getParent() == -1 && huffmanTree[i].getWeight() != 0) {
                tempTree[j] = new TempNode(huffmanTree[i].getWeight(), i);
                j++;
            }
        }

        int m1, m2;
        m1 = m2 = 0;
        for (i = 0; i < j; i++) {
            //此处不让取到相等，是因为结点中有相同权值的时候，m1取最前的
            if (tempTree[i].getNewWeight() < tempTree[m1].getNewWeight()) {
                m1 = i;
            }
        }
        for (i = 0; i < j; i++) {
            //当m1在第一个位置的时候，m2向后移一位
            if (m1 == m2) {
                m2++;
            }
            //此处取到相等，是让在结点中有相同的权值的时候，
            if (tempTree[i].getNewWeight() <= tempTree[m2].getNewWeight() && i != m1)

            //m2取最后的那个。
            {
                m2 = i;
            }
        }

        min[0] = tempTree[m1].getPlace();
        min[1] = tempTree[m2].getPlace();
        return min;
    }

    //创建huffmanTree
    public static void createHuffmanTree(Node[] huffmanTree, int n) {
        if (n <= 1) {
            System.out.println("Parameter Error!");
        }
        int m = 2 * n - 1;
        //initHuffmanTree(huffmanTree,m);

        for (int i = n; i < m; i++) {
            int[] min = selectMin(huffmanTree, i);
            int min1 = min[0];
            int min2 = min[1];
            huffmanTree[min1].setParent(i);
            huffmanTree[min2].setParent(i);
            huffmanTree[i].setLeftChild(min1);
            huffmanTree[i].setRightChild(min2);
            huffmanTree[i].setWeight(huffmanTree[min1].getWeight() + huffmanTree[min2].getWeight());
        }
    }

    /*创建huffmanCode*/
    public static void createHuffmanCode(Node[] huffmanTree, NodeCode[] huffmanCode, int n) {
        Scanner input = new Scanner(System.in);
        char[] code = new char[10];
        int start;
        int c;
        int parent;
        int temp;

        code[n - 1] = '0';
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuffer = new StringBuilder();
            start = n - 1;
            c = i;
            while ((parent = huffmanTree[c].getParent()) >= 0) {
                start--;
                code[start] = ((huffmanTree[parent].getRightChild() == c) ? '0' : '1');
                c = parent;

            }
            for (; start < n - 1; start++) {
                stringBuffer.append(code[start]);
            }
            huffmanCode[i].setCode(stringBuffer.toString());
        }
    }

    //输出huffmanCode
    public static void outputsHuffmanCode(NodeCode[] huffmanCode, int n, Integer integer) {
        System.out.println("Case " + integer);
        for (int i = 0; i < n; i++) {
            System.out.println(huffmanCode[i].getCharacter() + ":" + huffmanCode[i].getCode());
        }
    }

    //主函数
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int nums;
        nums = input.nextInt();
        int i = 0;
        while (nums-- != 0) {
            int n = 0;
            int m = 0;
            System.out.print("请输入字符个数：");
            n = input.nextInt();
            m = 2 * n - 1;
            Node[] huffmanTree = new Node[m];
            NodeCode[] huffmanCode = new NodeCode[n];

            //初始化huffmanTree,huffmanCode
            initHuffmanTree(huffmanTree, m);
            initHuffmanCode(huffmanCode, n);

            //获取huffmanCode的符号
            System.out.print("请输入哈夫曼编码的字符：");
            getHuffmanCode(huffmanCode, huffmanTree, n);

            //创建huffmanTree
            createHuffmanTree(huffmanTree, n);
            //创建huffmanCode
            createHuffmanCode(huffmanTree, huffmanCode, n);

            //输出huffmanCode编码
            outputsHuffmanCode(huffmanCode, n, ++i);
        }
    }
}

