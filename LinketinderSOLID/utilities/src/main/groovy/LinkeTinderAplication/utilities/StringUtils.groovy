/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package LinkeTinderAplication.utilities

import LinkeTinderAplication.list.LinkedList

class StringUtils {
    static String join(LinkedList source) {
        return JoinUtils.join(source)
    }

    static LinkedList split(String source) {
        return SplitUtils.split(source)
    }
}
