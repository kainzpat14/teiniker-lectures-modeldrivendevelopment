import * as esbuild from 'esbuild';

const minify = process.argv.includes('--minify');
const watch  = process.argv.includes('--watch');

const shared = {
    bundle: true,
    format: 'cjs',
    platform: 'node',
    target: 'node18',
    minify,
    sourcemap: !minify
};

const extensionBundle = {
    ...shared,
    entryPoints: ['src/extension.ts'],
    outfile: 'out/extension.cjs',
    external: ['vscode']
};

const serverBundle = {
    ...shared,
    entryPoints: ['src/language-server/main.ts'],
    outfile: 'out/language-server/main.cjs'
};

if (watch) {
    const [extCtx, srvCtx] = await Promise.all([
        esbuild.context(extensionBundle),
        esbuild.context(serverBundle)
    ]);
    await Promise.all([extCtx.watch(), srvCtx.watch()]);
    console.log('Watching for changes...');
} else {
    await Promise.all([
        esbuild.build(extensionBundle),
        esbuild.build(serverBundle)
    ]);
    console.log('Build complete.');
}
