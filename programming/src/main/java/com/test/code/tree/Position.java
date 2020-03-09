package com.test.code.tree;

/**
 *
 * @author Rogerio J. Gentil
 */
public interface Position<E> {
    
    /**
     * Returns the element stored at this position.
     * 
     * @return An element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}
