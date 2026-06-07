# Redis on Docker

Runs **Redis 7 (Alpine)** in Docker with data persistence enabled.

---

## Prerequisites

- [Docker Desktop](https://www.docker.com/products/docker-desktop/) installed and running

---

## Directory Structure

```
redis/
├── docker-compose.yml   # Service definition
└── README.md
```

---

## Quick Start

```bash
docker compose up -d
```

---

## Connection Details

| Field    | Value       |
|----------|-------------|
| Host     | `localhost` |
| Port     | `6379`      |
| Password | _(none)_    |

### Test with redis-cli

```bash
docker exec -it redis redis-cli ping
# PONG
```

### Connect from an app

```
redis://localhost:6379
```

---

## Persistence

Data is saved to the `redis_data` Docker volume. The server is configured to snapshot to disk every **60 seconds** if at least **1 key** has changed (`--save 60 1`), so data survives container restarts.

---

## Common Commands

```bash
# Stop the container (data is preserved)
docker compose down

# Stop and delete all data (full reset)
docker compose down -v

# View logs
docker logs -f redis

# Open interactive redis-cli
docker exec -it redis redis-cli
```

---

## Troubleshooting

### Port 6379 already in use

Another Redis instance may be running locally. Either stop it or change the host port in `docker-compose.yml`:

```yaml
ports:
  - "6380:6379"   # use 6380 on the host instead
```

### Enable password authentication

Add `--requirepass yourpassword` to the `command` in `docker-compose.yml`:

```yaml
command: redis-server --save 60 1 --loglevel warning --requirepass yourpassword
```

Then connect with:

```bash
docker exec -it redis redis-cli -a yourpassword ping
```
