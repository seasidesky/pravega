/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.emc.pravega.common.netty;

import com.emc.pravega.common.netty.WireCommands.AbortTransaction;
import com.emc.pravega.common.netty.WireCommands.CommitTransaction;
import com.emc.pravega.common.netty.WireCommands.CreateSegment;
import com.emc.pravega.common.netty.WireCommands.CreateTransaction;
import com.emc.pravega.common.netty.WireCommands.DeleteSegment;
import com.emc.pravega.common.netty.WireCommands.GetStreamSegmentInfo;
import com.emc.pravega.common.netty.WireCommands.GetTransactionInfo;
import com.emc.pravega.common.netty.WireCommands.KeepAlive;
import com.emc.pravega.common.netty.WireCommands.ReadSegment;
import com.emc.pravega.common.netty.WireCommands.SealSegment;
import com.emc.pravega.common.netty.WireCommands.SetupAppend;

/**
 * A RequestProcessor that hands off all implementation to another RequestProcessor.
 * This is useful for creating subclasses that only handle a subset of Commands.
 */
public abstract class DelegatingRequestProcessor implements RequestProcessor {

    public abstract RequestProcessor getNextRequestProcessor();

    @Override
    public void setupAppend(SetupAppend setupAppend) {
        getNextRequestProcessor().setupAppend(setupAppend);
    }

    @Override
    public void append(Append append) {
        getNextRequestProcessor().append(append);
    }

    @Override
    public void readSegment(ReadSegment readSegment) {
        getNextRequestProcessor().readSegment(readSegment);
    }

    @Override
    public void getStreamSegmentInfo(GetStreamSegmentInfo getStreamInfo) {
        getNextRequestProcessor().getStreamSegmentInfo(getStreamInfo);
    }
    
    @Override
    public void getTransactionInfo(GetTransactionInfo getTransactionInfo) {
        getNextRequestProcessor().getTransactionInfo(getTransactionInfo);
    }
    
    @Override
    public void createSegment(CreateSegment createStreamsSegment) {
        getNextRequestProcessor().createSegment(createStreamsSegment);
    }

    @Override
    public void createTransaction(CreateTransaction createTransaction) {
        getNextRequestProcessor().createTransaction(createTransaction);
    }

    @Override
    public void commitTransaction(CommitTransaction commitTransaction) {
        getNextRequestProcessor().commitTransaction(commitTransaction);
    }

    @Override
    public void abortTransaction(AbortTransaction abortTransaction) {
        getNextRequestProcessor().abortTransaction(abortTransaction);
    }
    
    @Override
    public void sealSegment(SealSegment sealSegment) {
        getNextRequestProcessor().sealSegment(sealSegment);
    }

    @Override
    public void deleteSegment(DeleteSegment deleteSegment) {
        getNextRequestProcessor().deleteSegment(deleteSegment);
    }

    @Override
    public void keepAlive(KeepAlive keepAlive) {
        getNextRequestProcessor().keepAlive(keepAlive);
    }

}