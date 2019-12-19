package io.webfolder.cdp.libuv;

import static io.webfolder.cdp.libuv.Libuv.CDP4J_UV_SUCCESS;
import static io.webfolder.cdp.libuv.Libuv.uv_close;
import static io.webfolder.cdp.libuv.Libuv.uv_pipe_init;
import static io.webfolder.cdp.libuv.Libuv.uv_read_stop;
import static io.webfolder.cdp.libuv.Libuv.uv_stream_set_blocking;
import static io.webfolder.cdp.libuv.UvLogger.debug;
import static org.graalvm.nativeimage.UnmanagedMemory.free;
import static org.graalvm.nativeimage.UnmanagedMemory.malloc;
import static org.graalvm.nativeimage.c.struct.SizeOf.get;
import static org.graalvm.word.WordFactory.nullPointer;

import io.webfolder.cdp.libuv.Libuv.pipe;

class UvPipe {

    private final UvLoop loop;

    private pipe pipe;

    UvPipe(UvLoop loop) {
        this.loop = loop;
        pipe = malloc(get(pipe.class));
    }

    boolean init() {
        debug("-> UvPipe.init()");
        if ( uv_pipe_init(loop.getPeer(), pipe, 0) != CDP4J_UV_SUCCESS() ) {
            debug("<- UvPipe.init(): false");
            return false;
        }
        uv_stream_set_blocking(pipe, 1);
        debug("<- UvPipe.init(): true");
        return true;
    }

    pipe getPeer() {
        return pipe;
    }

    void dispose() {
        if (pipe.isNonNull()) {
            debug("-> UvPipe.dispose()");
            debug("-> uv_read_stop()");
			uv_read_stop(pipe);
            debug("<- uv_read_stop()");
            debug("-> uv_close()");
            uv_close(pipe, nullPointer());
            debug("<- uv_close()");
            free(pipe);
            debug("<- UvPipe.dispose()");
        }
    }
}
