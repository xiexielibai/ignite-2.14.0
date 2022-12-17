/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.visor.query;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.UUID;
import org.apache.ignite.internal.dto.IgniteDataTransferObject;
import org.apache.ignite.internal.util.typedef.internal.S;
import org.apache.ignite.internal.util.typedef.internal.U;

/**
 * Arguments for task {@link VisorQueryCancelOnInitiatorTask}.
 */
public class VisorQueryCancelOnInitiatorTaskArg extends IgniteDataTransferObject {
    /** */
    private static final long serialVersionUID = 0L;

    /** Query initiator. */
    private UUID nodeId;

    /** Query ID to cancel. */
    private long qryId;

    /** Default constructor. */
    public VisorQueryCancelOnInitiatorTaskArg() {
        // No-op.
    }

    /**
     * @param qryId Query id.
     * @param nodeId Query initiator.
     */
    public VisorQueryCancelOnInitiatorTaskArg(UUID nodeId, long qryId) {
        this.nodeId = nodeId;
        this.qryId = qryId;
    }

    /** @return Query initiator. */
    public UUID getNodeId() {
        return nodeId;
    }

    /** @return Query ID to cancel. */
    public long getQueryId() {
        return qryId;
    }

    /** {@inheritDoc} */
    @Override protected void writeExternalData(ObjectOutput out) throws IOException {
        U.writeUuid(out, nodeId);
        out.writeLong(qryId);
    }

    /** {@inheritDoc} */
    @Override protected void readExternalData(byte protoVer, ObjectInput in) throws IOException, ClassNotFoundException {
        nodeId = U.readUuid(in);
        qryId = in.readLong();
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return S.toString(VisorQueryCancelOnInitiatorTaskArg.class, this);
    }
}
