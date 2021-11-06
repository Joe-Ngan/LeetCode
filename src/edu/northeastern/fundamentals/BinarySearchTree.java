package edu.northeastern.fundamentals;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    //成员方法使用的成员变量
    //记录根结点
    private Node root;
    //记录个数
    private int N;

    //内部类：Node
    private class Node{
        //内部类包含使用的变量
        public Key key;

        private Value value;

        public Node left;

        public Node right;

        public Node(Key key, Value value, Node left, Node right ){
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //成员方法
    public int size(){
        return N;
    }

    //添加元素
    public void put(Key key, Value value){
        //首次添加元素
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value){

        if(node==null){
            //如果node为空
            N++;
            return new Node(key, value, null, null);
        }

        //如果node不为空，则比较node键与key的大小。
        int cmp = key.compareTo(node.key);
        if(cmp>0){
            //key大于node的key，让key去找右子树（注意：key是新来的，node是根）
            node.right = put(node.right, key, value);
        }else if(cmp<0){
            //key小于node的key，让key去找左子树（注意：key是新来的，node是根）
            node.left = put(node.left, key, value);
        }else{
            node.value = value;
        }

        return node;
    }

    //查询树中指定key对应的value
    public Value get(Key key){
        return get(root, key);
    }

    //指定的树中查找key对应的值
    public Value get(Node x, Key key){
        //x树为null
        if(x==null){
            return null;
        }else{
            int cmp = key.compareTo(x.key);
            if(cmp>0){
                return get(x.right, key);
            }else if(cmp<0){
                return get(x.left, key);
            }else{
                return x.value;
            }
        }
        //x树不为null

    }
    //删除树中key对应的value
    public void delete(Key key){
        delete(root, key);
    }

    //删除指定树中的key对应的value，并返回删除后的新树
    public Node delete(Node x, Key key){
        if(x==null) {
            return null;
        }else{
            //如果node不为空，则比较node键与key的大小。
            int cmp = key.compareTo(x.key);
            if(cmp>0){
                //key大于node的key，让key去找右子树（注意：key是新来的，node是根）
                x.right = delete(x.right, key);
            }else if(cmp<0){
                //key小于node的key，让key去找左子树（注意：key是新来的，node是根）
                x.left = delete(x.left, key);
            }else{
                //key等与node的key，就是要删除该节点。
                N--;
                //找到替换节点（右子树中最小结点）
                if(x.right==null){
                    return x.left;
                }
                if(x.left==null){
                    return x.right;
                }

                Node minNode = x.right;
                while(minNode.left!=null){
                    minNode = minNode.left;
                }
                //删除替换结点(让其父节点指向null)
                Node n = x.right;
                while(n.left!=null){
                    if(n.left.left==null){
                        n.left=null;
                    }else {
                        n = n.left;
                    }
                }
                //让被删除结点x的左右关系，转移给替代结点minNode。
                minNode.left = x.left;
                minNode.right = x.right;
                //让被删除结点x的父节点，指向minNode。
                x = minNode;

                //这两行再看看
                minNode.left = x.left;     // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                x = x.right;

            }
        }
        return x;
    }
}
