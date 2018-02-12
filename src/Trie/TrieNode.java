package Trie;

import java.util.LinkedList;

/**
 * 节点类
 */
public class TrieNode {
    private LinkedList<TrieNode> children;//子节点
    private char data;//节点字符
    private int freq;//频率
    boolean isEnd;//是否是最后

    public TrieNode(char data) {
        this.data = data;
        freq = 0;
        isEnd = false;
        this.children = new LinkedList<>();
    }

    /**
     * 查找字符子节点
     * @param c
     * @return
     */
    public TrieNode childNode(char c) {
        if (null != children) {
            for (TrieNode child : children) {
                if (child.getData() == c) {
                    return child;
                }
            }
        }
        return null;
    }

    public LinkedList<TrieNode> getChildren() {
        return children;
    }

    public void setChildren(LinkedList<TrieNode> children) {
        this.children = children;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public void addFreq(int step) {
        this.freq += step;
    }

    public void subFreq(int step) {
        this.freq -= step;
    }


    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
}
