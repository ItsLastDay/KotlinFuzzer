#!/bin/bash
# If fuzzing is done on a remote server, you may want to copy files from "crashing tests" folder to local folder.
# This can be done like this:
#   rsync --filter='- /*/' --dirs --remove-source-files --archive --compress --verbose  user@x.x.x.x:/path/crashing_tests/ ./crashing_tests
# 
# If fuzzing is done locally, no work is needed.
