#!/bin/sh

# Make sure we can find sbt
hash sbt 2>/dev/null || { echo >&2 "Please install sbt first.  Aborting."; exit 1; }

sbt stage
./target/universal/stage/bin/itext-bug

