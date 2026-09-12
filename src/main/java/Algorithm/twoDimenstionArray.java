package Algorithm;

public class twoDimenstionArray {
    /* array include 8 bytes markword 4 bytes cp and 4 bytes length of array
    局部性原理
    这里只讨论空间局部性
    CPU读取内存中的数据很慢，为了让读取变快，会将数据放入缓存中，因为缓存中的数据读取很快，以后如果需要再次用到这个数据，就可以直接从缓存中读取，而不要去内存中读取，这样数据读取的速度就会很快了
    缓存中的最小存储单位是缓存行，一行缓存行大小是64个字节，因此从缓存中读取数据的时候是以缓存行为单位来进行读取的，当读取的数据大小不足一个缓存行的大小的时候，会读取其临近的数据来凑满一个缓存行，这就叫做空间局部性

*/


}

