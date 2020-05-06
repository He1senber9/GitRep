package club.vann.leetcode.common;

/**
 * Created with IntelliJ IDEA.
 * User: fanyu
 * Date: 2020/4/29
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface Cache<K, V> {
    /**
     * 向缓存中加入数据
     * @param key
     * @param value
     */
    public void put(K key, V value);

    /**
     * 根据key从缓存中获取数据
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * 删除指定的数据
     * @param key
     */
    public V remove(K key);
}
