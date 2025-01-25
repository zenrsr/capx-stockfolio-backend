#!/bin/sh
# wait-for-it.sh

set -e

host="$1"
port="$2"
shift 2
cmd="$@"

until nc -z "$host" "$port"; do
  echo "Waiting for $host:$port..."
  sleep 1
done

echo "$host:$port is available!"
exec $cmd