package datastructures.dictionaries;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.trie.TrieMap;
import cse332.types.BString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * See cse332/interfaces/trie/TrieMap.java
 * and cse332/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        public HashTrieNode() {
            this(null);
        }

        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieMap<A, K, V>.HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    @Override
    public V insert(K key, V value) {
        if (key == null || value == null){
            throw new IllegalArgumentException();
        }
        HashTrieNode front = (HashTrieNode) this.root;
        for (A search : key){
            if (!front.pointers.containsKey(search)){
                front.pointers.put(search, new HashTrieNode());
                front = front.pointers.get(search);
            }
            front = front.pointers.get(search);
        }
        if (front.value == null){
            size++;
        }
        front.value = value;
        return front.value;
    }

    @Override
    public V find(K key) {
        if (key == null){
            throw new IllegalArgumentException();
        }
        HashTrieNode front = (HashTrieNode) this.root;
        for (A temp : key){
            if (!front.pointers.containsKey(temp)){
                return null;
            }
            front = front.pointers.get(temp);
        }
        return front.value;
    }

    @Override
    public boolean findPrefix(K key) {
        if (key == null){
            throw new IllegalArgumentException();
        }
        HashTrieNode traverse = (HashTrieNode) this.root;
        for (A search : key){
            if (!traverse.pointers.containsKey(search)){
                return false;
            }
            traverse = traverse.pointers.get(search);
        }
        return true;
    }

    @Override
    public void delete(K key) {
        throw new NotYetImplementedException();
    }

    @Override
    public void clear() {
        HashTrieNode front = (HashTrieNode) this.root;
        front.pointers.clear();
        this.size = 0;
    }
}
