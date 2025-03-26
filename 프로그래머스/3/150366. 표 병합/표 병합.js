function solution(commands) {
    const SIZE = 50;
    const parents = Array.from({ length: SIZE + 1 }, () =>
        Array.from({ length: SIZE + 1 }, (_, c) => [0, c])
    ).map((row, r) => row.map(cell => [r, cell[1]]));

    const values = Array.from({ length: SIZE + 1 }, () =>
        Array(SIZE + 1).fill("")
    );

    function find(r, c) {
        const [pr, pc] = parents[r][c];
        if (pr === r && pc === c) return [r, c];
        const root = find(pr, pc);
        parents[r][c] = root;
        return root;
    }

    function union(r1, c1, r2, c2) {
        const root1 = find(r1, c1);
        const root2 = find(r2, c2);
        if (root1[0] === root2[0] && root1[1] === root2[1]) return;

        // root1을 기준으로 병합
        const [rr1, cc1] = root1;
        const [rr2, cc2] = root2;

        // 값 병합
        if (!values[rr1][cc1] && values[rr2][cc2]) {
            values[rr1][cc1] = values[rr2][cc2];
        }

        for (let r = 1; r <= SIZE; r++) {
            for (let c = 1; c <= SIZE; c++) {
                const [pr, pc] = parents[r][c];
                if (pr === rr2 && pc === cc2) {
                    parents[r][c] = [rr1, cc1];
                }
            }
        }

        parents[rr2][cc2] = [rr1, cc1];
    }

    function unmerge(r, c) {
        const [pr, pc] = find(r, c);
        const originalValue = values[pr][pc];

        const group = [];
        for (let i = 1; i <= SIZE; i++) {
            for (let j = 1; j <= SIZE; j++) {
                const [pi, pj] = find(i, j);
                if (pi === pr && pj === pc) {
                    parents[i][j] = [i, j];
                    values[i][j] = "";
                }
            }
        }

        values[r][c] = originalValue;
    }

    const result = [];

    for (const command of commands) {
        const parts = command.split(" ");
        if (parts[0] === "UPDATE") {
            if (parts.length === 4) {
                const [_, r, c, value] = parts;
                const [pr, pc] = find(Number(r), Number(c));
                values[pr][pc] = value;
            } else {
                const [_, value1, value2] = parts;
                for (let r = 1; r <= SIZE; r++) {
                    for (let c = 1; c <= SIZE; c++) {
                        const [pr, pc] = find(r, c);
                        if (values[pr][pc] === value1) {
                            values[pr][pc] = value2;
                        }
                    }
                }
            }
        } else if (parts[0] === "MERGE") {
            const [_, r1, c1, r2, c2] = parts.map(Number);
            union(r1, c1, r2, c2);
        } else if (parts[0] === "UNMERGE") {
            const [_, r, c] = parts.map(Number);
            unmerge(r, c);
        } else if (parts[0] === "PRINT") {
            const [_, r, c] = parts.map(Number);
            const [pr, pc] = find(r, c);
            result.push(values[pr][pc] || "EMPTY");
        }
    }

    return result;
}
