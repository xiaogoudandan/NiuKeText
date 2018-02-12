package Trie;

public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        this.root = new TrieNode(' ');
    }

    /**
     * 插入节点
     *
     * @param word
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode child = current.childNode(word.charAt(i));//插入字符，返回节点
            if (null != child)//节点存在  将返回节点作为当前节点，
                current = child;
            else {//节点不存在 添加新节点 当前节点为新节点
                current.getChildren().add(new TrieNode(word.charAt(i)));
                current = current.childNode(word.charAt(i));
            }
            current.addFreq(1);//出现次数
        }
        current.setEnd(true);
    }

    /**
     * 删除
     * @param word
     */
    public void remove(String word) {
        if (!search(word))
            return;

        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode child = current.childNode(c);//查找到子节点
            if (child.getFreq() == 1) {
                current.getChildren().remove(child);//子节点出现一次 直接删除
                return;
            }else{
                child.subFreq(1);//子节点出现大于一次 频率减一，继续查找子节点
                current = child;
            }
        }
        current.setEnd(false);
    }

    /**
     * 查找是否存在
     * @param word
     * @return
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (null == current.childNode(word.charAt(i)))
                return false;
            else
                current = current.childNode(word.charAt(i));
        }

        if (current.isEnd())
            return true;
        else
            return false;
    }

    /**
     * 查找返回节点
     * @param word
     * @return
     */
    public TrieNode searchNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (null == current.childNode(word.charAt(i)))
                return null;
            else
                current = current.childNode(word.charAt(i));
        }

        if (current.isEnd())
            return current;
        else
            return null;
    }

    /**
     * 获取词频
     * @param word
     * @return
     */
    public int getFreq(String word) {
        TrieNode trieNode = searchNode(word);
        if(null != trieNode){
            return trieNode.getFreq();
        }else{
            return 0;
        }
    }
}
