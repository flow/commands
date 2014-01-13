/*
 * This file is part of Flow.
 *
 * Copyright (c) 2013 Spout LLC <http://www.spout.org/>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.flowpowered.commands;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.flowpowered.commands.Command.ProcessingMode;

public class Alias {
    private final List<String> path;
    private final Command parent;

    public Alias(List<String> path, Command parent) {
        this.path = path;
        this.parent = parent;
    }

    protected void process(CommandSender sender, CommandArguments args, ProcessingMode mode) throws CommandException {
        for (int i = 0; i < path.size(); ++i) {
            args.setArgOverride(CommandArguments.SUBCOMMAND_ARGNAME + (args.getDepth() + i), path.get(i));
        }
        parent.processChild(sender, args, mode);
    }

    public List<String> getPath() {
        return Collections.unmodifiableList(path);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(path);
        hash = 97 * hash + Objects.hashCode(parent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alias other = (Alias) obj;
        if (!Objects.equals(path, other.path)) {
            return false;
        }
        if (!Objects.equals(parent, other.parent)) {
            return false;
        }
        return true;
    }
}
