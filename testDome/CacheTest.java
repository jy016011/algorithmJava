package testDome;

public class CacheTest {
    public static void main(String[] args) {
        OptimizedDiskCache optimizedDiskCache1 = new OptimizedDiskCache();
        Cache cache = (Cache) optimizedDiskCache1;

//        MemoryCache memoryCache = new MemoryCache();
//        Cache cache = (Cache) memoryCache;
//        DiskCache diskCache = (DiskCache) cache;

//        DiskCache diskCache = new DiskCache();
//        OptimizedDiskCache optimizedDiskCache = (OptimizedDiskCache) diskCache;

        OptimizedDiskCache optimizedDiskCache2 = new OptimizedDiskCache();
        DiskCache diskCache = (DiskCache) optimizedDiskCache2;

//        Cache cache = new Cache();
//        MemoryCache memoryCache = (MemoryCache) cache;

        OptimizedDiskCache optimizedDiskCache = new OptimizedDiskCache();
        Cache cache2 = (Cache) optimizedDiskCache;
        DiskCache diskCache2 = (DiskCache) cache2;
    }
}
