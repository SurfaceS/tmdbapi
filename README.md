## Running tests
You need the following environment variables in order to run all tests:
```
TMDB_API_KEY
TMDB_API_READ_TOKEN
TMDB_API_ACCESS_TOKEN
TMDB_USERNAME
TMDB_PASSWORD
TMDB_ACCOUNT
```

Most are easy to get via TMDB but `TMDB_API_ACCESS_TOKEN` is tricky. See https://github.com/UniversalMediaServer/UniversalMediaServer/pull/4037#issuecomment-2081531952 for instructions.

## Deployment
Run `mvn deploy -P release`.

On macOS you might need to symlink `gpg2` to `gpg` as described at https://stackoverflow.com/a/69920288/2049714