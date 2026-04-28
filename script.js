    const modal = document.getElementById('modalMatricula');
    const modalContent = document.getElementById('modalContent');
    const nomePlanoSpan = document.getElementById('nomePlanoModal');

    function openModal(plano) {
        // 1. Atualiza o texto do modal com o nome do plano clicado
        nomePlanoSpan.innerText = plano;

        // Muda a cor do nome do plano para dar um destaque extra (Diamante fica Laranja)
        if(plano === 'Diamante') {
            nomePlanoSpan.className = 'text-orange-500 font-bold uppercase';
        } else {
            nomePlanoSpan.className = 'text-blue-500 font-bold uppercase';
        }

        // 2. Tira a invisibilidade física (display: none)
        modal.classList.remove('hidden');
        modal.classList.add('flex');

        // 3. O truque dos 10ms para a animação de opacidade e zoom acontecer
        setTimeout(() => {
            modal.classList.remove('opacity-0');
            modalContent.classList.remove('scale-95'); // Tira o zoom negativo
        }, 10);
    }

    function closeModal() {
        // 1. Faz a animação reversa de sumir primeiro
        modal.classList.add('opacity-0');
        modalContent.classList.add('scale-95');

        // 2. Espera a animação acabar (300ms do Tailwind) para esconder fisicamente
        setTimeout(() => {
            modal.classList.add('hidden');
            modal.classList.remove('flex');
        }, 300);
    }

    // Fecha o modal se o usuário clicar na área preta (fora da caixa)
    modal.addEventListener('click', function(e) {
        if(e.target === modal) {
            closeModal();
        }
    });
