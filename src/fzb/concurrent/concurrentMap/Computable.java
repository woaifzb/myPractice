package fzb.concurrent.concurrentMap;

/**
 * @author fzb
 * @date   2017-3-25下午10:59:03
 */
/**
 * java并发编程实战 P86 -89
 */
public interface Computable<A, V> {
	V compute(A arg) throws InterruptedException;
}
