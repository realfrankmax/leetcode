package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @leetcode: 588. Design In-Memory File System
 */
public class FileSystem {
    public static void main(String[] args) {}

    private Node root;
    public FileSystem() {
        this.root = new Node();
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        Node curr = this.root;
        for (int i = 1; i < dirs.length; i++) {
            if (!curr.children.containsKey(dirs[i])) {
                return new ArrayList<>();
            }
            curr = curr.children.get(dirs[i]);
        }
        // If the path is a file, only return the file
        if (curr.isFile) {
            return List.of(dirs[dirs.length-1]);
        }
        List<String> res = new ArrayList<>(curr.children.keySet());
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        this.buildDir(path);
    }

    private Node buildDir(String path) {
        String[] dirs = path.split("/");
        Node curr = this.root;
        for (int i = 1; i < dirs.length; i++) {
            curr.children.computeIfAbsent(dirs[i], x -> new Node());
            curr = curr.children.get(dirs[i]);
            // if (curr.isFile) {
            //     throw new Exception();
            // }
        }
        return curr;
    }
    
    public void addContentToFile(String filePath, String content) {
        Node curr = this.buildDir(filePath);
        curr.isFile = true;
        curr.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        String[] dirs = filePath.split("/");
        Node curr = this.root;
        for (int i = 1; i < dirs.length; i++) {
            if (!curr.children.containsKey(dirs[i])) {
                return "";
            }
            curr = curr.children.get(dirs[i]);
        }
        return curr.content;
    }

    class Node {
        boolean isFile;
        String content;
        Map<String, Node> children;
        public Node() {
            this.isFile = false;
            this.content = "";
            this.children = new HashMap<>();
        }
    }
}
