/*
 * This file is part of Flow Chat and Commands, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.flowpowered.commands.exception;

import com.flowpowered.commands.Command;

public class UnknownSubcommandException extends UserFriendlyCommandException {
    private static final long serialVersionUID = 1788649361912438898L;
    private final Command parent;
    private final String commandLine;
    private final String child;

    public UnknownSubcommandException(Command parent, String commandLine, String child) {
        super("Unknown command: /" + commandLine);
        this.commandLine = commandLine;
        this.child = child;
        this.parent = parent;
    }

    public String getCommandLines() {
        return this.commandLine;
    }

    public String getChildName() {
        return this.child;
    }

    public Command getParent() {
        return this.parent;
    }
}
