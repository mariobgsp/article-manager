CREATE TABLE articles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    author VARCHAR(100) NOT NULL
);

-- Insert the 24 new articles into the 'articles' table
INSERT INTO articles (title, body, author) VALUES
('The Future of Artificial Intelligence', 'Artificial Intelligence continues to advance, transforming industries and shaping the future of technology.', 'Alex Johnson'),
('Sustainable Living: Reducing Carbon Footprint', 'Individuals and communities adopt sustainable practices to reduce their carbon footprint and combat climate change.', 'Bella Thompson'),
('Digital Transformation in Education', 'Education undergoes a digital transformation, with the integration of technology enhancing learning experiences.', 'Charlie Davis'),
('The Impact of Augmented Reality in Healthcare', 'Augmented Reality (AR) applications revolutionize healthcare, offering innovative solutions for medical training and patient care.', 'Diana Miller'),
('Renewable Energy: Harnessing the Power of the Sun', 'Solar energy gains prominence as a clean and renewable source of power, driving the transition to sustainable energy solutions.', 'Eric Turner'),
('The Role of Blockchain in Financial Services', 'Blockchain technology transforms the financial services industry, offering secure and decentralized solutions for transactions.', 'Fiona White'),
('Advancements in Robotics: A Look into the Future', 'Robotics advancements lead to breakthroughs in automation, manufacturing, and everyday life.', 'George Martinez'),
('The Changing Landscape of Online Retail', 'E-commerce evolves with changing consumer behaviors, emphasizing convenience, personalization, and innovative shopping experiences.', 'Hannah Brown'),
('The Promise of Quantum Internet', 'Researchers explore the potential of quantum internet, promising ultra-secure communication and data transfer.', 'Isaac Wilson'),
('Mind-Body Connection: The Importance of Mental Health', 'The recognition of the mind-body connection emphasizes the importance of mental health in overall well-being.', 'Jessica Adams'),
('Smart Cities: Urban Planning for the Future', 'Cities worldwide embrace smart technologies for improved infrastructure, sustainability, and quality of life.', 'Kevin Green'),
('The Influence of Social Media on Global Movements', 'Social media platforms become catalysts for social and political movements, shaping the global narrative.', 'Lily Turner'),
('Biotechnology Breakthroughs in Medicine', 'Biotechnological advancements lead to breakthroughs in medicine, from personalized therapies to gene editing.', 'Michaela Davis'),
('The Resurgence of Space Exploration', 'Countries and private companies invest in space exploration, with renewed interest in lunar and Martian missions.', 'Nathan Smith'),
('The Impact of 5G Technology on Connectivity', 'The rollout of 5G technology promises faster and more reliable connectivity, transforming communication and industries.', 'Olivia Martinez'),
('Culinary Innovation: Trends in Modern Cuisine', 'Chefs and food enthusiasts explore innovative techniques and ingredients, shaping the future of culinary arts.', 'Peter Johnson'),
('The Evolution of Wearable Technology', 'Wearable devices continue to evolve, integrating seamlessly into daily life and contributing to personal health monitoring.', 'Quinn Turner'),
('Environmental Conservation Through Technology', 'Technology plays a vital role in environmental conservation efforts, from monitoring ecosystems to promoting sustainable practices.', 'Rachel Green'),
('The Art and Science of Data Visualization', 'Data visualization becomes an integral part of decision-making processes, conveying complex information in a comprehensible manner.', 'Samuel Adams'),
('The Future of Work: Adapting to Remote Collaboration', 'Remote collaboration tools redefine the way teams work, contributing to a flexible and dynamic future of work.', 'Tina White'),
('Innovations in Urban Mobility: Beyond Traditional Transportation', 'Urban mobility solutions evolve with innovations such as electric scooters, bike-sharing, and sustainable transportation alternatives.', 'Ulysses Davis'),
('Revolutionizing Agricultural Practices with Precision Farming', 'Precision farming technologies enhance agricultural efficiency, from automated machinery to data-driven decision-making.', 'Victoria Turner');
